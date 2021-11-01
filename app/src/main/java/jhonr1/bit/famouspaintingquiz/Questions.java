package jhonr1.bit.famouspaintingquiz;

/**
 * Declaration of Question object
 */
public class Questions {
    int picture;
    String option1;
    String option2;
    String option3;
    String option4;
    String correctAns;
    String info;

    /**
     * Gets the information about the painting
     * @return Information about the painting
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets the information about the painting
     * @param info Sets the information about the painting
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Gets the image for the question
     * @return The image for the question
     */
    public int getPicture() {
        return picture;
    }

    /**
     * Sets the image for the question
     * @param picture Image as input
     */
    public void setPicture(int picture) {
        this.picture = picture;
    }

    /**
     * Gets the option
     * @return the option
     */
    public String getOption1() {
        return option1;
    }

    /**
     * Sets the optional answer
     * @param option1 The optional answer as input
     */
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    /**
     * Gets the option
     * @return the option
     */
    public String getOption2() {
        return option2;
    }

    /**
     * Sets the optional answer
     * @param option2 The optional answer as input
     */
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    /**
     * Gets the option
     * @return the option
     */
    public String getOption3() {
        return option3;
    }

    /**
     * Sets the optional answer
     * @param option3 The optional answer as input
     */
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    /**
     * Gets the option
     * @return the option
     */
    public String getOption4() {
        return option4;
    }

    /**
     * Sets the optional answer
     * @param option4 The optional answer as input
     */
    public void setOption4(String option4) {
        this.option4 = option4;
    }

    /**
     * Gets the correct answer
     * @return The correct answer
     */
    public String getCorrectAns() {
        return correctAns;
    }

    /**
     * Sets the correct answer
     * @param correctAns Correct answer as input
     */
    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    @Override
    public String toString() {
        return "option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", correctAns='" + correctAns + '\'' ;
    }

    /**
     * Creates new Question object with given parameters
     * @param picture Question image
     * @param option1 optional answer1
     * @param option2 optional answer2
     * @param option3 optional answer3
     * @param option4 optional answer4
     * @param correctAns correct answer
     * @param info Information about the painting and painter
     */
    public Questions(int picture, String option1, String option2, String option3, String option4, String correctAns, String info) {
        this.picture = picture;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAns = correctAns;
        this.info = info;
    }

}
