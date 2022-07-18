package org.profamilia.hc.view.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFMerger {
 
    /**
     * @param streamOfPDFFiles
     * @param outputStream
     * @param paginate
     * @return a byte array of the merged PDF
     */
    public static byte[] concatPDFs(List<InputStream> pdfs, ByteArrayOutputStream outputStream) {
        Document document = new Document();
        
        try {
            List<PdfReader> readers = new ArrayList<PdfReader>();
            int totalPages = 0;
            Iterator<InputStream> iteratorPDFs = pdfs.iterator();
 
            // Create Readers for the pdfs.
            while (iteratorPDFs.hasNext()) {
                InputStream pdf = iteratorPDFs.next();
                PdfReader pdfReader = new PdfReader(pdf);
                readers.add(pdfReader);
                pdf.close();
                totalPages += pdfReader.getNumberOfPages();
            }
            
            // Create a writer for the outputstream
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
 
            document.open();
            
            PdfContentByte cb = writer.getDirectContent(); // Holds the PDF data
 
            PdfImportedPage page;
            int currentPageNumber = 0;
            int pageOfCurrentReaderPDF = 0;
            Iterator<PdfReader> iteratorPDFReader = readers.iterator();
 
            // Loop through the PDF files and add to the output.
            while (iteratorPDFReader.hasNext()) {
                PdfReader pdfReader = iteratorPDFReader.next();

                // Create a new page in the target for each source page.
                while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
                	// Set document size based on the original PDF's size
                    document.setPageSize(pdfReader.getCropBox(++pageOfCurrentReaderPDF));
                    document.newPage();              
                    currentPageNumber++;                 
                    page = writer.getImportedPage(pdfReader,
                            pageOfCurrentReaderPDF);
                    cb.addTemplate(page, 0, 0);    
                }
                pageOfCurrentReaderPDF = 0;
            }
            outputStream.flush();
            document.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen())
                document.close();
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return outputStream.toByteArray();
    }
    
    public static byte[] concatBytePDFs(List<byte[]> pdfs, ByteArrayOutputStream outputStream) {

        Iterator<byte[]> iteratorPDFs = pdfs.iterator();
        List<InputStream> ISpdfs = new ArrayList<InputStream>();
        
        while (iteratorPDFs.hasNext()) {
            ByteArrayInputStream bis = new ByteArrayInputStream(iteratorPDFs.next());
            ISpdfs.add(bis);
        }

        PDFMerger.concatPDFs(ISpdfs, outputStream);

        return outputStream.toByteArray();
    }
    
    public static Integer paginasTotalPDF(byte[] pdf) {
        Integer paginas = 0;
        ByteArrayInputStream bis = new ByteArrayInputStream(pdf);
        PdfReader pdfReader = null;
        try {
            pdfReader = new PdfReader(bis);
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        paginas = pdfReader.getNumberOfPages();
        return paginas;
    }
    
    public static byte[] adicionarPieTotalPaginas(byte[] pdf, ByteArrayOutputStream outputStream) {
        Document document = new Document();
        
        try {
            int totalPages = 0;
            PdfReader pdfReader = new PdfReader(pdf);
            totalPages = pdfReader.getNumberOfPages();
            
            // Create a writer for the outputstream
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            
            PdfContentByte cb = writer.getDirectContent(); // Holds the PDF data
    
            PdfImportedPage page;
            int currentPageNumber = 0;
            int pageOfCurrentReaderPDF = 0;

            // Create a new page in the target for each source page.
            while (pageOfCurrentReaderPDF < totalPages) {
                    // Set document size based on the original PDF's size
                document.setPageSize(pdfReader.getCropBox(++pageOfCurrentReaderPDF));
                document.newPage();              
                currentPageNumber++;                 
                page = writer.getImportedPage(pdfReader, pageOfCurrentReaderPDF);
                cb.addTemplate(page, 0, 0);    
                    
                // adicionar pagina de pagina total //
                //crear fuente
                BaseFont bf =  BaseFont.createFont(BaseFont.HELVETICA,
                        BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                cb.beginText();
                cb.setFontAndSize(bf, 8);
                cb.setTextMatrix(495, 20);
                cb.showText("P�gina : " +currentPageNumber + "/" + totalPages);
                cb.endText();
            }
            outputStream.flush();
            document.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen())
                document.close();
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return outputStream.toByteArray();
    }

    
}