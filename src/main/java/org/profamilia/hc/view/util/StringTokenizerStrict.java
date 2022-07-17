package org.profamilia.hc.view.util;

import java.util.NoSuchElementException; 
import java.util.StringTokenizer; 
import java.util.Vector; 

public class StringTokenizerStrict extends StringTokenizer 
{ 
protected String delim = " f"; 
protected String storedToken = null; 
protected boolean lastWasToken = true; 
protected Vector tokens = null; 
protected int currentToken = 0; 
protected boolean returnTokens = false; 
protected boolean internal = false; 
protected synchronized void buildInternal() 
{ 
tokens = new Vector(); 
try { 
while ( true ) { 
tokens.addElement(nextTokenInternal()); 
} 
} catch ( NoSuchElementException e ) { 
tokens.trimToSize(); 
currentToken = 0; 
lastWasToken = true; 
storedToken = null; 
return; 
} 
} 
public StringTokenizerStrict(String s) 
{ 
this(s," f"); 
} 
public StringTokenizerStrict(String s,String delim) 
{ 
this(s,delim,false); 
} 
public StringTokenizerStrict(String s,String delim,boolean returnTokens) 
{ 
super (s,delim,true); 
this.delim = delim; 
this.returnTokens = returnTokens; 
buildInternal(); 
} 
public int countTokens() 
{ 
return tokens.size() - currentToken; 
} 
public boolean hasMoreElements() 
{ 
return ( countTokens() != 0 ); 
} 
public Object nextElement() 
{ 
return nextToken(); 
} 

public String nextToken(String delim) 
{ 
if ( delim.equals(this.delim) ) 
return nextToken(); 
this.delim = delim; 
buildInternal(); 
return nextToken(); 
} 
public String nextToken() 
{ 
if ( internal ) 
return super.nextToken(); 
return (String) tokens.elementAt(currentToken++); 
} 
protected String nextTokenInternal() 
{ 
try { 
internal = true; 
if ( storedToken != null ) { 
String s = storedToken; 
storedToken = null; 
return s; 
} 
String s = super.nextToken(delim); 
if ( s.length() == 1 ) 
if ( delim.indexOf(s) != -1 ) 
if ( lastWasToken ) { 
if ( returnTokens ) 
storedToken = s; 
return ""; 
} else { 
lastWasToken = true; 
if ( returnTokens ) 
return s; 
else 
return nextTokenInternal(); 
} 
lastWasToken = false; 
return s; 
} finally { 
internal = false; 
} 
} 
public boolean hasMoreTokens() 
{ 
return hasMoreElements(); 
} 

public static void main(String args[]) { 
StringTokenizerStrict tokenizer= new 
StringTokenizerStrict("Pedro|Peres|12333444|Caracas|2523344|ofiJuan|Gomez|14123321|Valencia||ofi2","|"); 

while(tokenizer.hasMoreTokens()) { 
System.out.println(tokenizer.nextToken()); 
} 
} 
}