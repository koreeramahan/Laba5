package Game;
import java.util.Random;

//отвечает за общие характеристики, общий класс, от которого наследуется все другими классами
public class Person
{
    public static final int MIN_NUMBER = 1; //загадать число от
    public static final int MAX_NUMBER = 10; //до
    public static final int DAMAGE = 10; //урон
    private int m_health = 100; //сколько жизни
    private String m_name = "Person";
    private int m_secretNumber = MIN_NUMBER; //загаданное число
    protected Random rand;

    public Person()
    {
        rand = new Random();
    }
    //задать имя
    public void setName(String name)
    {
        m_name = name;
    }
    //получить имя
    public String getName()
    {
        return m_name;
    }
    //задать количество жизней
    public void setHealth(int health)
    {
        m_health = health;
    }
    //получить сколько осталось жизни
    public int getHealth()
    {
        return m_health;
    }
    //противник загадывает число
    public void setSecretNumber(int secretNumber)
    {
        m_secretNumber = secretNumber;
    }
    //какое число загадал противник
    public int getSecretNumber()
    {
        return m_secretNumber;
    }
    //сравниваем загаданное и введенное число
    public boolean isHit(int number)
    {
        if (number == m_secretNumber)
        {
            hit();
            return true;
        }
        else return false;
    }
    //число угадано
    public void hit()
    {
        m_health -= DAMAGE;
    }
}
