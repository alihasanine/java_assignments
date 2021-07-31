/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AsmaaAbdelkader
 */
public class CSVDAO <T extends FillData<T>>{
    private  String file;
    private  Supplier<T> supplier;
    private List<T> list; //list of objects

    public CSVDAO(String file ,Supplier <T> supplier) {
        this.file = file;
        this.supplier = supplier;
        list = new ArrayList<T>();
    }
    
    public  List<T> getData(){
        
        try {
            Scanner input = new Scanner(new File(file));
            if(input.hasNext())
                input.nextLine(); // discard header
            
            while(input.hasNext()){
           
               String data = input.nextLine().replaceAll(",,", ",Nan,");     
                String [] row =data.split("," , 11);
                list.add(supplier.get().fill(row));
                }
          
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    
}
