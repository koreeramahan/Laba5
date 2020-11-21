package Game;

public class Enemy extends Person
{
    //задаем имя и загадываем число
    public Enemy(String name)
    {
        setName(name);
        generateSecretNumber();
    }
    //враг пытается угадает число
    public boolean attack(Person target)
    {
        int number=rand.nextInt(MAX_NUMBER-MIN_NUMBER+1)+MIN_NUMBER;
        if (target.isHit(number)) return true;
        else return false;
    }
    //рандомим число
    public void generateSecretNumber()
    {
        setSecretNumber(rand.nextInt(MAX_NUMBER-MIN_NUMBER+1)+MIN_NUMBER);
    }
    //если угадали, отнимаем жизнь и загадываем новое число
    @Override
    public void hit()
    {
        setHealth(getHealth()-DAMAGE);
        generateSecretNumber();
    }
}