package com.example.quizmaster;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
        public static final String TABLE_NAME2 = "quiz2_QUESTIONS";
        public static final String COL_QUESTION_QUIZ2 = "question";
        public static final String COL_OP1 = "option1";
        public static final String COL_OP2 = "option2";
        public static final String COL_OP3 = "option3";
        public static final String COL_OP4 = "option4";
        public static final String COLUMN_ANS = "answer_nr";
        public static final String TABLE_NAME3 = "quiz3_QUESTIONS";
        public static final String COL_QUESTION_QUIZ3 = "question";
        public static final String QUZ3_OP1 = "option1";
        public static final String QUZ3_OP2 = "option2";
        public static final String QUZ3_OP3 = "option3";
        public static final String QUZ3_OP4 = "option4";
        public static final String QUZ3_ANS = "answer_nr";
        public static final String TABLE_NAME4 = "quiz4_QUESTIONS";
        public static final String COL_QUESTION_QUIZ4 = "question";
        public static final String QUZ4_OP1 = "option1";
        public static final String QUZ4_OP2 = "option2";
        public static final String QUZ4_OP3 = "option3";
        public static final String QUZ4_OP4 = "option4";
        public static final String QUZ4_ANS = "answer_nr";

    }
}

