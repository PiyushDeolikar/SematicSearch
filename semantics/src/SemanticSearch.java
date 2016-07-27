/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.dictionary.Dictionary;
import net.didion.jwnl.dictionary.MorphologicalProcessor;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import semantics.Compare;

/**
 *
 * @author Sony
 */
public class SemanticSearch {

    /**
     * @param args the command line arguments
     */
    public static String getNoun(String args,String args2,String args3) throws FileNotFoundException {
        // TODO code application logic here
        String result="";
        try {
        
        JWNL.initialize(new FileInputStream("C:/Users/Sony/Desktop/file_properties.xml"));    
        MorphologicalProcessor proc = Dictionary.getInstance().getMorphologicalProcessor();
        IndexWord indexWord = proc.lookupBaseForm(POS.VERB, "bank");
        IndexWord indexWord2 = proc.lookupBaseForm(POS.NOUN, args2);
        IndexWord indexWord3 = proc.lookupBaseForm(POS.ADVERB, "good");
        IndexWord indexWord4 = proc.lookupBaseForm(POS.ADJECTIVE, "kind");
        
        int senseNum = 0;
//        System.out.println("Verbs 88888888888888888888");
//            for (Synset synset : indexWord.getSenses()) {
//                senseNum++;
//                System.out.println("For sense: " + senseNum + " (" + synset.getGloss() + ")");
//                Word[] words = synset.getWords();
//
////                for (Word word : words) {
////                    System.out.println("\t" + word.getLemma() + "(" + word.getPOS() + ")");
////
////                }
//            }
            System.out.println("Nouns 88888888888888888888");
            senseNum = 0;
            for (Synset synset3 : indexWord2.getSenses()) {
                senseNum++;
                System.out.println("\n\nFor sense: " + senseNum + " (" + synset3.getGloss() + ")");
                
                    //System.out.println("\t" + word.getLemma() + "(" + word.getPOS() + ")");
                    if(senseNum==1){
                    result= "The meaning is: "+synset3.getGloss().substring(0,synset3.getGloss().indexOf(";") );
                    }
                    System.out.println();
                    if(synset3.getGloss().contains(args3)){
                        result="The meaning is: "+ synset3.getGloss().substring(0,synset3.getGloss().indexOf(";") );
                        System.out.println(synset3.getGloss().substring(0,synset3.getGloss().indexOf(";") ));
                        return result;
                    }
                

//            System.out.println(synset3.getGloss().substring(synset3.getGloss().indexOf(";")+1).replaceAll("\"", ""));
//            String str= synset3.getGloss().substring(synset3.getGloss().indexOf(";")+1).replaceAll("\"", "");
//            Compare c;
//            int len = str.split(";").length;
//            System.out.println("len " +len);
//            if(len>1)    {
//            System.out.println("arr 1 " +str.split(";")[1]);   
//            c = new Compare(args, str.split(";")[0]);
//            }else 
//                c = new Compare(args, str);
//            
//            System.out.println("score " +c.getResult());
//                c.getResult();
//                for (Word word : words) {
//                    System.out.println("\t" + word.getLemma() + "(" + word.getPOS() + ")");
//
//                }
                    
            }
            
//            System.out.println("Adverbs 88888888888888888888");
//            senseNum = 0;
//            for (Synset synset1 : indexWord3.getSenses()) {
//                senseNum++;
//                System.out.println("For sense: " + senseNum + " (" + synset1.getGloss() + ")");
//                Word[] words = synset1.getWords();
//
//                for (Word word : words) {
//                    System.out.println("\t" + word.getLemma() + "(" + word.getPOS() + ")");
//
//                }
//            }
//            System.out.println("Adjective 88888888888888888888");
//            senseNum = 0;
//            for (Synset synset2 : indexWord4.getSenses()) {
//                senseNum++;
//                System.out.println("For sense: " + senseNum + " (" + synset2.getGloss() + ")");
//                Word[] words = synset2.getWords();
//
//                for (Word word : words) {
//                    System.out.println("\t" + word.getLemma() + "(" + word.getPOS() + ")");
//
//                }
//            }
        } catch (JWNLException ex) {
            Logger.getLogger(SemanticSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

public StringBuilder getMean(String inputWord) throws FileNotFoundException{
StringBuilder result= new StringBuilder();
int flag=0;
      try {
        
        JWNL.initialize(new FileInputStream("C:/Users/Sony/Desktop/file_properties.xml"));    
        MorphologicalProcessor proc = Dictionary.getInstance().getMorphologicalProcessor();
        IndexWord indexWord = proc.lookupBaseForm(POS.VERB, inputWord);
        IndexWord indexWord2 = proc.lookupBaseForm(POS.NOUN, inputWord);
        IndexWord indexWord3 = proc.lookupBaseForm(POS.ADVERB, inputWord);
        IndexWord indexWord4 = proc.lookupBaseForm(POS.ADJECTIVE, inputWord);
        int senseNum = 0;
        System.out.println("Verbs 88888888888888888888");
        result.append("\n");
        result.append("The word you entered is: "+inputWord);
        result.append("\n");
        
        if(null!=indexWord){   
        
            for (Synset synset : indexWord.getSenses()) {
                
                senseNum++;
                System.out.println("For sense: " + senseNum + " (" + synset.getGloss() + ")");
                Word[] words = synset.getWords();
                if(senseNum==1){
                flag=1;
                result.append("The stem word is: "+words[0].getLemma());    
                result.append("\n");
            }
                if(senseNum==1){
                result.append("1: ");    
                result.append(synset.getGloss());
                result.append("\n");
                }
                for (Word word : words) {
                    System.out.println("\t" + word.getLemma() + "(" + word.getPOS() + ")");
                    
                }
            if(senseNum==1){
                result.append(words[0].getLemma()+"\t"+words[0].getPOS());
                result.append("\n");
            }    
            }
        }else{
            result.append("\n");
           result.append("1: No Verbs found in dictionary for the word.");
           result.append("\n");
        }
            
            System.out.println("Nouns 88888888888888888888");
            senseNum = 0;
            if(null!=indexWord2){
            for (Synset synset3 : indexWord2.getSenses()) {
                senseNum++;
                System.out.println("For sense: " + senseNum + " (" + synset3.getGloss() + ")");
                Word[] words = synset3.getWords();
                if(senseNum==1 &&flag==0){
                flag=1;
                result.append("The stem word is: "+words[0].getLemma());    
                result.append("\n");
            }
                if(senseNum==1){
                result.append("2: ");    
                result.append(synset3.getGloss());
                result.append("\n");
                }
                for (Word word : words) {
                    System.out.println("\t" + word.getLemma() + "(" + word.getPOS() + ")");

                }
                if(senseNum==1){
                result.append(words[0].getLemma()+"\t"+words[0].getPOS());
                result.append("\n");
                }
            }
            }else{
                result.append("\n");
           result.append("2: No Nouns found in dictionary for the word.");
           result.append("\n");
            }
            
            System.out.println("Adverbs 88888888888888888888");
            senseNum = 0;
       if(null!=indexWord3){     
            for (Synset synset1 : indexWord3.getSenses()) {
                senseNum++;
                System.out.println("For sense: " + senseNum + " (" + synset1.getGloss() + ")");
                Word[] words = synset1.getWords();
                if(senseNum==1 &&flag==0){
                flag=1;
                result.append("The stem word is: "+words[0].getLemma());    
                result.append("\n");
            }
                if(senseNum==1){
                result.append("3: ");    
                result.append(synset1.getGloss());
                result.append("\n");
                }
                for (Word word : words) {
                    System.out.println("\t" + word.getLemma() + "(" + word.getPOS() + ")");

                }
                if(senseNum==1){
                result.append(words[0].getLemma()+"\t"+words[0].getPOS());
                result.append("\n");
                }
            }
      }else{
           result.append("\n");
           result.append("3: No Adverbs found in dictionary for the word.");
           result.append("\n");
       }
            System.out.println("Adjective 88888888888888888888");
            senseNum = 0;
            if(null!=indexWord4){
            for (Synset synset2 : indexWord4.getSenses()) {
                senseNum++;
                System.out.println("For sense: " + senseNum + " (" + synset2.getGloss() + ")");
                Word[] words = synset2.getWords();
                if(senseNum==1 &&flag==0){
                flag=1;
                result.append("The stem word is: "+words[0].getLemma());    
                result.append("\n");
            }
                if(senseNum==1){
                result.append("4: ");    
                result.append(synset2.getGloss());
                result.append("\n");
                }
                for (Word word : words) {
                    System.out.println("\t" + word.getLemma() + "(" + word.getPOS() + ")");

                }
                if(senseNum==1){
                result.append(words[0].getLemma()+"\t"+words[0].getPOS());
                result.append("\n");
                }
            }
            }else{
                
                result.append("\n");
           result.append("4: No Adjectives found in dictionary for the word.");
           result.append("\n");
            }
        } catch (JWNLException ex) {
            Logger.getLogger(SemanticSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
return result;
    }
}