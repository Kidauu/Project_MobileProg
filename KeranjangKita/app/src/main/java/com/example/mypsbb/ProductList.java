package com.example.mypsbb;

import java.io.Serializable;

public class ProductList implements Serializable {
    private int mImageProductResource;
    private String mTextView1;
    private String mTextView2;

    public ProductList(int imageProductResource, String textView1, String textView2) {
        mImageProductResource = imageProductResource;
        mTextView1 = textView1;
        mTextView2 = textView2;
    }

    public int getImageProductResource() {
        return mImageProductResource;
    }

    public String getTextView1() {
        return mTextView1;
    }

    public String getTextView2() {
        return mTextView2;
    }
}
