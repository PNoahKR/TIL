import java.util.Comparator;
import java.util.PriorityQueue;

class Person //implements Comparable<Person>
{
	String name;
	int age;
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

//	// 나이순으로 정렬할게 오름차순으로
//	@Override
//	public int compareTo(Person o) {
//		// 오름차순 정렬
//		return this.age - o.age;
//	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
public class Heap03_PersonPQ {
	public static void main(String[] args) {
//		PriorityQueue<Person> pq = new PriorityQueue<>();
//		PriorityQueue<Person> pq = new PriorityQueue<>(new NameComparator());
		
		PriorityQueue<Person>pq = new PriorityQueue<>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.age == o2.age) {
					return o1.name.compareTo(o2.name);
				}
				return o2.age - o1.age;
			}
			
			
		});
		
		pq.add(new Person("최현진", 28));
		pq.add(new Person("이서연", 10));
		pq.add(new Person("양띵균", 45));
		
		
		System.out.println(pq.poll());
	}
}
