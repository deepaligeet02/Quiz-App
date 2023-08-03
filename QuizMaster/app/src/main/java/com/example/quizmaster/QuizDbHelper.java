package com.example.quizmaster;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quizmaster.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QuizMAster.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL("create Table users (username varchar(20)  ,Email varchar(20),Password varchar(8)primary key,Phone varchar(10))");
//CREATE TABLE IN SQLITE
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

        final String SQL_CREATE_QUESTIONS_TABLE2 = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME2 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COL_QUESTION_QUIZ2 + " TEXT, " +
                QuestionsTable.COL_OP1 + " TEXT, " +
                QuestionsTable.COL_OP2 + " TEXT, " +
                QuestionsTable.COL_OP3 + " TEXT, " +
                QuestionsTable.COL_OP4 + " TEXT, " +
                QuestionsTable.COLUMN_ANS + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE2);

        fillsecondquiz();
        final String SQL_CREATE_QUESTIONS_TABLE3 = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME3 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COL_QUESTION_QUIZ3 + " TEXT, " +
                QuestionsTable.QUZ3_OP1 + " TEXT, " +
                QuestionsTable.QUZ3_OP2 + " TEXT, " +
                QuestionsTable.QUZ3_OP3 + " TEXT, " +
                QuestionsTable.QUZ3_OP4 + " TEXT, " +
                QuestionsTable.QUZ3_ANS + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE3);
        fillthirdquiz();
        final String SQL_CREATE_QUESTIONS_TABLE4 = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME4 + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COL_QUESTION_QUIZ4 + " TEXT, " +
                QuestionsTable.QUZ4_OP1 + " TEXT, " +
                QuestionsTable.QUZ4_OP2 + " TEXT, " +
                QuestionsTable.QUZ4_OP3 + " TEXT, " +
                QuestionsTable.QUZ4_OP4 + " TEXT, " +
                QuestionsTable.QUZ4_ANS + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE4);
        fillfourthquiz();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME4);
        onCreate(db);
    }

    public long insertdata(String username, String Email, String Password, String Phone) {
        SQLiteDatabase db = this.getWritableDatabase();//getwritable fun use for storing data into database
        ContentValues contents = new ContentValues();//contentvalues is nothing but collectionits a formate
        contents.put("username", username);
        contents.put("Email", Email);
        contents.put("Password", Password);
        contents.put("Phone", Phone);
        long result = db.insert("users", null, contents);
        return result;
    }

    public boolean chekusernamepassword(String username, String password) {
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from users where username= ? and password = ?", new String[]{username, String.valueOf(password)});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("Blockchain is a peer-to-peer _____distributed ledger technology that makes the records of any digital asset transparent and unchangeable.", "a) Decentralized", "b) Demanding ", "c) Securen ", "d) Popular", 1);
        addQuestion(q1);
        Question q2 = new Question("Blockchain networks are much _____ and deal with no real single point of failure.", "a) Convenient",
                "a) Simpler ", "c)Easier to scale", "d) Faster", 3);
        addQuestion(q2);
        Question q3 = new Question("Blockchain has ____ versions", "a) 1",
                "b) 5 ", "c) 2", "d) 3", 4);
        addQuestion(q3);
        Question q4 = new Question(" Who introduced the digital online cryptocurrency known as Bitcoin?", "a) Nick Szabo",
                "b)  Satoshi Nakamoto ", "c) Wei Dai", "d)    Hal Finney", 2);
        addQuestion(q4);
        Question q5 = new Question("What does a block in a Blockchain have?", "a)  Header & Digital ledger",
                "b) Bitcoins & Input", "c)Transactions & Bitcoins", "d) Header & Transaction", 4);
        addQuestion(q5);

    }

    private void fillsecondquiz() {
        Question q1 = new Question("Who is the father of cloud computing?", " a) Sharon B. Codd ", "  b) Edgar Frank Codd", "c) J.C.R. Licklider ", "d) Charles Bachman", 3);
        addQ_TABLE2(q1);
        Question q2 = new Question(" Which of the following are the features of cloud computing?", "a) Security", "b) Availability", "c) Large Network Access", "d) All of the mentioned", 4);
        addQ_TABLE2(q2);
        Question q3 = new Question("Which of the following is a type of cloud computing service?", "a) Service-as-a-Software", "b)  Software-and-a-Server", "c) Software-as-a-Service", "d) Software-as-a-Server", 3);
        addQ_TABLE2(q3);
        Question q4 = new Question("Which of the following model attempts to categorize a cloud network based on four dimensional factors?", "a) Cloud Cube", "b) Cloud Square", "c) Cloud Service", "d) All of the mentioned", 1);
        addQ_TABLE2(q4);
        Question q5 = new Question("   Which of the following is the most refined and restrictive cloud service model?", "a) IaaS",
                "b)  PaaS", "c) SaaS", "d) CaaS", 2);
        addQ_TABLE2(q5);
    }

    private void fillthirdquiz() {
        Question q1 = new Question(" which of the following is/are keywords of Docker?", " a) develop ", "  b) ship", "c) run ", "d) All of the above", 4);
        addQ_TABLE3(q1);
        Question q2 = new Question("  Docker License is?", "a) Free", "b) Paid", "c) Both A and B", "d)None of the above", 4);
        addQ_TABLE3(q2);
        Question q3 = new Question("Which of the following is the registry which is used to host various Docker images?", "a) Docker Compose", "b)  Docker Engine", "c) Docker Hub", "d)None of the above", 3);
        addQ_TABLE3(q3);
        Question q4 = new Question("  Which of the following command displays all of the pictures that are presently installed on the system?", "a) Docker images", "b)  See images", "c) Docker see images", "d) None of the mentioned", 1);
        addQ_TABLE3(q4);
        Question q5 = new Question("  Which of the following command is used to display the statistics of a running container?\n", "a) Docker statistics", "b)  Stats", "c) Docker statics", "d) Docker stats", 4);
        addQ_TABLE3(q5);
    }

    private void fillfourthquiz() {
        Question q1 = new Question("What is the full form of Devops?", " a) Drive and Operations ", "  b) Digital and Operations", "c) Development And Operations ", "d) None of the above", 3);
        addQ_TABLE4(q1);
        Question q2 = new Question("Identify the tool for DevOps?", "a) Monit", "b) Nagios", "c) Jenkins", "d)All of the above", 4);
        addQ_TABLE4(q2);
        Question q3 = new Question("Which of the following is not a part of DevOps lifecycle ____", "a)  Build", "b) Operating", "c) Plan", "d) Code", 2);
        addQ_TABLE4(q3);
        Question q4 = new Question("Which of the following is most important DevOps KPI?", "a)  Deployment frequency", "b) Meantime to failure recovery", "c) Both (A) and (B)", "d) Defect Volume", 3);
        addQ_TABLE4(q4);
        Question q5 = new Question("Identify the correct set of DevOps values?", "a)Culture, Automation, Lean, Metrics, Sharing", "b)Culture, Collaboration, Communication, Sharingy", "c)Culture, Automation, Lean, Measurement, Sharing", "d) All of the Above", 3);
        addQ_TABLE4(q5);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    private void addQ_TABLE2(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COL_QUESTION_QUIZ2, question.getQuestion());
        cv.put(QuestionsTable.COL_OP1, question.getOption1());
        cv.put(QuestionsTable.COL_OP2, question.getOption2());
        cv.put(QuestionsTable.COL_OP3, question.getOption3());
        cv.put(QuestionsTable.COL_OP4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANS, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME2, null, cv);
    }

    private void addQ_TABLE3(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COL_QUESTION_QUIZ3, question.getQuestion());
        cv.put(QuestionsTable.QUZ3_OP1, question.getOption1());
        cv.put(QuestionsTable.QUZ3_OP2, question.getOption2());
        cv.put(QuestionsTable.QUZ3_OP3, question.getOption3());
        cv.put(QuestionsTable.QUZ3_OP4, question.getOption4());
        cv.put(QuestionsTable.QUZ3_ANS, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME3, null, cv);
    }

    private void addQ_TABLE4(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COL_QUESTION_QUIZ4, question.getQuestion());
        cv.put(QuestionsTable.QUZ4_OP1, question.getOption1());
        cv.put(QuestionsTable.QUZ4_OP2, question.getOption2());
        cv.put(QuestionsTable.QUZ4_OP3, question.getOption3());
        cv.put(QuestionsTable.QUZ4_OP4, question.getOption4());
        cv.put(QuestionsTable.QUZ4_ANS, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME4, null, cv);
    }

    //for 1st quiz
    @SuppressLint("Range")
    public List<Question> getAllQuestions() {
        List<Question> questionList;
        questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    //for2nd quiz
    @SuppressLint("Range")
    public List<Question> getAllQuestion_TABLE2() {
        List<Question> questionList;
        questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME2, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COL_QUESTION_QUIZ2)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COL_OP1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COL_OP2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COL_OP3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COL_OP4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANS)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    //for 3rd quiz
    @SuppressLint("Range")
    public List<Question> getAllQuestion_TABLE3() {
        List<Question> questionList;
        questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME3, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COL_QUESTION_QUIZ3)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.QUZ3_OP1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.QUZ3_OP2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.QUZ3_OP3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.QUZ3_OP4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.QUZ3_ANS)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

    @SuppressLint("Range")
    public List<Question> getAllQuestion_TABLE4() {
        List<Question> questionList;
        questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME4, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COL_QUESTION_QUIZ4)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.QUZ4_OP1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.QUZ4_OP2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.QUZ4_OP3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.QUZ4_OP4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.QUZ4_ANS)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
