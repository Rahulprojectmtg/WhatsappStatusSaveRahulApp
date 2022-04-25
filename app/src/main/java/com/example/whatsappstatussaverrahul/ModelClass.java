package com.example.whatsappstatussaverrahul;


import android.net.Uri;

public class ModelClass {

    String path,filename;
    Uri uri;

    public ModelClass(String path, String filename, Uri uri){

        this.path = path;
        this.filename = filename;
        this.uri = uri;
    }

    public ModelClass(){

    }

    public String getPath(){

        return path;
    }
    public void setpath(String path) {
        this.path = path;
    }

    public String getFilename(){
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Object getUri() {
    }

    public void setUri(Uri fromFile) {
    }
}
