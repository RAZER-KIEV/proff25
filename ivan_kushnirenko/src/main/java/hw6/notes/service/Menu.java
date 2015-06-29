package hw6.notes.service;

/**
 * Created by ivan on 17.06.15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import hw6.notes.domain.Notebook;

public class Menu {

    private NotebookServiceImpl nbsi;

    public NotebookServiceImpl getNbsi() {
        return nbsi;
    }

    public void setNbsi(NotebookServiceImpl nbsi) {
        this.nbsi = nbsi;
    }

    private void checkNotebookServiceImpl() {
        if (nbsi == null) {
            nbsi = new NotebookServiceImpl();
        }
    }

    private static String getData(String sout) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String gettedData = "";
        System.out.println(sout);
        while (gettedData.length() == 0) {
            try {
                gettedData = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (gettedData.length() == 0) {
                System.out.println("Input parametr must be non-empty!");
                System.out.println("Re-type parametr:");
            }
        }
        return gettedData;
    }

    private Notebook createNotebook() {
        String serial = getData("Please, type serial of your notebook here: ");
        String vendor = getData("Please, type vendor of your notebook here: ");
        String model = getData("Please, type model of your notebook here: ");
        String stringDate = getData("Please, type manufacture date of your notebook  in format yyyy.MM.dd here: ");
        Date manufDate = null;
        try {
            manufDate = new SimpleDateFormat("yyyy.MM.dd").parse(stringDate);
        } catch (ParseException e) {
            System.out.println("");
            e.printStackTrace();
        }
        Double price = null;
        try {
            price = Double.parseDouble(getData("Please, type price of your notebook here (Remember, price must be in the Double type!): "));
        } catch (NumberFormatException e) {
            System.out.println("");
            e.printStackTrace();
        }
        return new Notebook(serial, vendor, model, manufDate, price);
    }

    public void addNotedook() {
        checkNotebookServiceImpl();
        nbsi.add(createNotebook());
    }

    public void deleteNtb(Notebook notebook) {
        checkNotebookServiceImpl();
        nbsi.delete(notebook.getId());
    }

    void changePrice(Notebook notebook) {
        checkNotebookServiceImpl();
        nbsi.changePrice(notebook.getId(), notebook.getPrice());
    }

    void changeSerialVendor(Notebook notebook) {
        checkNotebookServiceImpl();
        nbsi.changeSerialVendor(notebook.getId(), notebook.getSerial(), notebook.getVendor());
    }

    void deleteByModel() {
        checkNotebookServiceImpl();
        String model = getData("Please, type the model of notebooks here: ");
        nbsi.deleteByModel(model);
    }

    void showByVendor() {
        checkNotebookServiceImpl();
        nbsi.findByVendor(getData("Please, type the vendor of notebooks here: "));
    }

    void showByPriceManufDate() {
        String stringDate = getData("Please, type manufacture date of your notebook  in format yyyy.MM.dd here: ");
        Date manufDate = null;
        try {
            manufDate = new SimpleDateFormat("yyyy.MM.dd").parse(stringDate);
        } catch (ParseException e) {
            System.out.println("");
            e.printStackTrace();
        }
        Double price = null;
        try {
            price = Double.parseDouble(getData("Please, type price of your notebook here (Remember, price must be in the Double type!): "));
        } catch (NumberFormatException e) {
            System.out.println("");
            e.printStackTrace();
        }
        checkNotebookServiceImpl();
        nbsi.findByPriceManufDate(price, manufDate);
    }

    void showBetweenPriceLtDateByVendor() {
        String vendor = getData("Please, type vendor of your notebook here: ");
        String stringDate = getData("Please, type manufacture date of your notebook  in format yyyy.MM.dd here: ");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy.MM.dd").parse(stringDate);
        } catch (ParseException e) {
            System.out.println("");
            e.printStackTrace();
        }
        Double priceFrom = null;
        try {
            priceFrom = Double.parseDouble(getData("Please, type priceFrom of your notebooks here (Remember, price must be in the Double type!): "));
        } catch (NumberFormatException e) {
            System.out.println("");
            e.printStackTrace();
        }
        Double priceTo = null;
        try {
            priceTo = Double.parseDouble(getData("Please, type priceTo of your notebooks here (Remember, price must be in the Double type!): "));
        } catch (NumberFormatException e) {
            System.out.println("");
            e.printStackTrace();
        }
        checkNotebookServiceImpl();
        nbsi.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
    }

    public static void main(String[] args) {
        Double price = null;
        label:
        try {
            price = Double.parseDouble(getData("Please, type price of your notebook here (Remember, price must be in the Double type!): "));
            System.out.println("Price is: "+price);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("ERROR: typed data is not requested format.");
            String message = getData("Do you want to set up parameter manufacture date?[Y/N]: ");
            if (message.equals("y")){
                break label;
            }
        }
    }
}