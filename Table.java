
/**
 * Write a description of class Table here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Table
{
    private int xPos;
    private int yPos;
    private int numPeople;
    private String name;
    public Table(String n,int x, int y, int num) {
        name = n;
        xPos = x;
        yPos = y;
        numPeople = num;
    }
    public int getX() {
        return xPos;
    }
    public int getY() {
        return yPos;
    }
}
