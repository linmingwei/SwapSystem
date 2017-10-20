import java.util.*;
import java.util.function.Predicate;

class  Apple
{
	private String color;
	private int weight;
	public Apple(String color,int weight){this.color=color; this.weight=weight;}
//	public void setColor(){this.color=color;}
//	public String getColor(){return this.color;}
//	public void setWeight(){this.weight=weight;}
//	public int getWeight(){return this.weight;}
	public static boolean isGreenApple(Apple a){return "green".equals(a.color);}
	public static boolean isHeavyApple(Apple a){return a.weight>150;}
	public interface Predicate<T>
	{
		Boolean test(T t);
	}
	public String toString(){
		return "color:"+color+"   weight:"+weight;
	}
	public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p)
	{
		List<Apple> result=new ArrayList<>();
		for (Apple temp:apples )
		{
			if (p.test(temp))
			{
				result.add(temp);
			}
		}
		return result;
		
	}
	public static void main(String[] args) 
	{
		List<Apple> apples=new ArrayList<>();
		apples.add(new Apple("yellow",13));
		apples.add(new Apple("green",123));
		apples.add(new Apple("blue",190));
		apples.add(new Apple("orange",24));
		System.out.println(apples);
		Apple.filterApples(apples,Apple::isGreenApple);
		System.out.println("Hello World!");
	}
}


