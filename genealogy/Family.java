import java.util.*;
public class Family {
    private Map<String, List<Person>> members;

    public Family() {
        this.members = new HashMap<>();
    }

//    public void add(Person person) {
//        String key = person.toString().split(",")[0];
//        members.put(key, person);
//    }

//    public void add(Person... people) {
//        for (Person person : people) {
//            String key = person.toString().split(",")[0];
//            members.put(key, person);
//        }
//    }

//    public Person get(String key) {
//        return members.get(key);
//    }

    public void add(Person... people) {
        for (Person person : people) {
            String key = person.toString().split(",")[0];
            members.putIfAbsent(key, new ArrayList<>());
            members.get(key).add(person);
            //members.get(key).sort(Comparator.naturalOrder());
        }
    }

    public Person[] get(String key) {
        List<Person> persons = members.getOrDefault(key, new ArrayList<>());
        persons.sort(Comparator.naturalOrder());
        return persons.toArray(new Person[1]);
    }

}
