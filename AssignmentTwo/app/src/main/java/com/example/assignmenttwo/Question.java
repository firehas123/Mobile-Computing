package com.example.assignmenttwo;

import android.os.Parcel;
import android.os.Parcelable;

class Question implements Parcelable {
    MyData ob; //question
    int index; //index of arrayList

    public Question(MyData object, int i) {
        this.ob = object;
        this.index = i;
    }

    protected Question(Parcel in) {
        index = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(index);
    }
}
