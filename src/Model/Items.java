package Model;

import java.sql.Date;

public class Items 
{
    public Items(){}
    private String idItems;
    private String nameItems;
    private int numberOfItems;
    private int Size;
    private int priceofItems;
    private String importDateItems;
    private String idBooth;
    public String getIdItems() {
        return idItems;
    }
    public void setIdItems(String idItems) {
        this.idItems = idItems;
    }
    public String getNameItems() {
        return nameItems;
    }
    public void setNameItems(String nameItems) {
        this.nameItems = nameItems;
    }
    public int getNumberOfItems() {
        return numberOfItems;
    }
    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
    
    public int getPriceofItems() {
        return priceofItems;
    }
    public void setPriceofItems(int priceofItems) {
        this.priceofItems = priceofItems;
    }
    public String getImportDateItems() {
        return importDateItems;
    }
    public void setImportDateItems(String importDateItems) {
        this.importDateItems = importDateItems;
    }
    public String getIdBooth() {
        return idBooth;
    }
    public void setIdBooth(String idBooth) {
        this.idBooth = idBooth;
    }
    public int getSize() {
        return Size;
    }
    public void setSize(int size) {
        Size = size;
    }
   
    

}
