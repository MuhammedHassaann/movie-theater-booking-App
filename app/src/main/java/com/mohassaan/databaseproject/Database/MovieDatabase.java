package com.mohassaan.databaseproject.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.mohassaan.databaseproject.Model.Customer;
import com.mohassaan.databaseproject.Model.Movie;
import com.mohassaan.databaseproject.Model.Ticket;
import com.mohassaan.databaseproject.Utilities.ImageConverter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MovieDatabase extends SQLiteOpenHelper {

    private static final String Database_Name="MovieDatabase.db";
    private static final int Database_Version=1;

    //Movies table
    private static final String Table1_name="Movies";
    private static final String Column_Title="Movie_Title";
    private static final String Column_Rating="Movie_Rating";
    private static final String Column_Genre="Movie_Genre";
    private static final String Column_Year="Movie_Year";
    private static final String Column_Price="Movie_Price";
    private static final String Column_Image="Movie_Image";

    //Customer table
    private static final String Table2_name="Customer";
    private static final String Column_ID="Customer_ID";
    private static final String Column_Name="Customer_Name";
    private static final String Column_Email="Customer_Email";
    private static final String Column_Password="Customer_Password";
    private static final String Column_BookedMovieTitle="Customer_BookedMovieTitle";
    private static final String Column_BookedMoviePrice="Customer_BookedMoviePrice";


    public MovieDatabase(@Nullable Context context) {
        super(context, Database_Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String movieQuery = "CREATE TABLE " + Table1_name +
                " (" + Column_Title + " Text, " +
                Column_Rating + " TEXT, " +
                Column_Genre + " TEXT, " +
                Column_Year + " TEXT, " +
                Column_Price + " TEXT, " +
                Column_Image+ " BLOB);";

        String customerQuery = "CREATE TABLE " + Table2_name +
                " (" + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Column_Name + " TEXT, " +
                Column_Email + " TEXT, " +
                Column_Password + " TEXT, " +
                Column_BookedMovieTitle + " TEXT, " +
                Column_BookedMoviePrice + " TEXT);";

        db.execSQL(movieQuery);
        db.execSQL(customerQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Table1_name);
        db.execSQL("DROP TABLE IF EXISTS " + Table2_name);
        onCreate(db);
    }


    public boolean checkEmail(String email){
        String checkEmailQuery="SELECT * FROM " + Table2_name + " WHERE " + Column_Email + " =?";
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery(checkEmailQuery,new String[]{email});
        if (cursor.getCount()>0)return true;
        else return false;
    }

    public boolean checkEmailPassword(String email,String password){
        String checkEmailPasswordQuery="SELECT * FROM " + Table2_name +
                " WHERE " + Column_Email + " =? AND "+ Column_Password +
                " =?";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(checkEmailPasswordQuery,new String[]{email,password});
        if (cursor.getCount()>0)return true;
        else return false;
    }


   public boolean addMovie (Movie movie){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        byte[] imageByteArray= ImageConverter.getBytes(movie.getMovieImage());
        cv.put(Column_Title,movie.getTitle());
        cv.put(Column_Rating,movie.getRating());
        cv.put(Column_Genre,movie.getGenre());
        cv.put(Column_Year, movie.getYear());
        cv.put(Column_Price,movie.getPrice());
        cv.put(Column_Image,imageByteArray);
        long result = db.insert(Table1_name,null,cv);
        if(result==-1){
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomer (String name, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Column_Name,name);
        cv.put(Column_Email,email);
        cv.put(Column_Password,password);
        long result = db.insert(Table2_name,null,cv);
        if(result==-1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean addTicket (Ticket ticket,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Column_BookedMovieTitle,ticket.getMovie_title());
        cv.put(Column_BookedMoviePrice,ticket.getMovie_price());
        //String query =Column_Email + " =?";
        int result =db.update(Table2_name,cv,"Customer_Email =?",new String[]{email});
        if(result==-1){
            return false;
        } else {
            return true;
        }
    }


   public ArrayList<Customer> getCustomerData(String email){
        String query = "SELECT * FROM " + Table2_name +
                " where "+Column_Email + " =?";

        ArrayList<Customer> arrayList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,new String[]{email});
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            String customer_name= cursor.getString(1);
            String customer_email= cursor.getString(2);
            //Works
            String movie_title= cursor.getString(4);
            String movie_price= cursor.getString(5);
            arrayList.add(new Customer(customer_name,customer_email,movie_title,movie_price));
            cursor.moveToNext();
        }
        return arrayList;
    }

    public ArrayList<Movie> getMovieByGenre(String genre){
        String query = "SELECT * FROM " + Table1_name +
                " where "+Column_Genre + " =?";

        ArrayList<Movie> arrayList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,new String[]{genre});
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            String movie_title= cursor.getString(0);
            String movie_rating= cursor.getString(1);
            String movie_genre= cursor.getString(2);
            String movie_year= cursor.getString(3);
            String movie_price= cursor.getString(4);
            byte [] bitmap = cursor.getBlob(5);
            Bitmap image = ImageConverter.getBitmapImage(bitmap);
            arrayList.add(new Movie(movie_title,movie_rating,movie_genre,movie_year,movie_price,image));
            cursor.moveToNext();
        }
        return arrayList;
    }

    public ArrayList<Movie> getAllMovies(){
        String query = "SELECT * FROM " + Table1_name ;

        ArrayList<Movie> arrayList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            String movie_title= cursor.getString(0);
            String movie_rating= cursor.getString(1);
            String movie_genre= cursor.getString(2);
            String movie_year= cursor.getString(3);
            String movie_price= cursor.getString(4);
            byte [] bitmap = cursor.getBlob(5);
            Bitmap image = ImageConverter.getBitmapImage(bitmap);
            arrayList.add(new Movie(movie_title,movie_rating,movie_genre,movie_year,movie_price,image));
            cursor.moveToNext();
        }
        return arrayList;
    }

    /*public ArrayList<Ticket> getTicket(String email){
        String query = "SELECT * FROM " + Table2_name +
                " where "+ Column_Email + " =?";

        ArrayList<Ticket> arrayList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,new String[]{"2"});
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            String ticket_customer_name= cursor.getString(1);
            String ticket_movie_title= cursor.getString(4);
            String ticket_movie_price= cursor.getString(5);
            arrayList.add(new Ticket(ticket_customer_name,ticket_movie_title,ticket_movie_price));
            cursor.moveToNext();
        }
        return arrayList;
    }*/


   public ArrayList<Customer> getTicket(String email){
        //String query = "SELECT * FROM " + Table2_name + " WHERE " + Column_Email;

        ArrayList<Customer> arrayList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Customer where Customer_Email=?",new String[]{email});
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            String customer_name= cursor.getString(cursor.getColumnIndexOrThrow("Customer_Name"));
            String customer_email= cursor.getString(cursor.getColumnIndexOrThrow("Customer_Email"));
            String movie_title= cursor.getString(cursor.getColumnIndexOrThrow("Customer_BookedMovieTitle"));
            String movie_price= cursor.getString(cursor.getColumnIndexOrThrow("Customer_BookedMoviePrice"));
            arrayList.add(new Customer(customer_name,customer_email,movie_title,movie_price));
            cursor.moveToNext();
        }
        return arrayList;
    }

    public void updateMovie (Movie movie,String movie_title){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Column_Title,movie.getTitle());
        cv.put(Column_Rating,movie.getRating());
        cv.put(Column_Genre,movie.getGenre());
        cv.put(Column_Year,movie.getYear());
        cv.put(Column_Price,movie.getPrice());
        db.update(Table1_name,cv," Movie_Title=? ",new String[]{movie_title});
    }

    public void deleteMovie (String movie_title) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table1_name," Movie_Title=? ",new String[]{movie_title});
    }

}
