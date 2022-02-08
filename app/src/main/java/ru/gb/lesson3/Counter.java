package ru.gb.lesson3;

import android.os.Parcel;
import android.os.Parcelable;

public class Counter implements Parcelable {

    private int counter = 0;

    public Counter() { }

    protected Counter(Parcel in) {
        counter = in.readInt();
    }

    public static final Creator<Counter> CREATOR = new Creator<Counter>() {
        @Override
        public Counter createFromParcel(Parcel in) {
            return new Counter(in);
        }

        @Override
        public Counter[] newArray(int size) {
            return new Counter[size];
        }
    };

    public int getCounter() {
        return counter;
    }

    public void increment(){
        counter++;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(counter);
    }
}
