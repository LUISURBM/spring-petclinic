package org.profamilia.hc.view;

import java.util.StringTokenizer;


public class Test {
    public Test() {
    }

    public static void main(String[] args) {


        //Test test = new Test();
        StringTokenizer st = new StringTokenizer("0,1,2,3,4,5,6,7,8,9", ",");
        int nDatos = st.countTokens();
        int[] datos = new int[nDatos];
        int i = 0;
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            datos[i] = Integer.valueOf(str).intValue();
            i++;
        }


    }
}
