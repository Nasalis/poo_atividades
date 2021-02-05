package aula07_ordenacao;

import java.util.ArrayList;
import java.util.Comparator;

class Profile implements Comparable<String> {
    String name;
    String lastname;
    String completeName;
    int birthyear;
    String profession;

    public Profile(String name, String lastname, int birthyear, String profession) {
        this.name = name;
        this.lastname = lastname;
        this.birthyear = birthyear;
        this.profession = profession;
        this.completeName = name + lastname;
    }

    public String toString() {
        return "\nName: " + this.name + " | Last Name: " + this.lastname + " | " + "Birth Year: " + this.birthyear + " | " + "Profession: " + this.profession;
    }

    public int compareTo(String other) {
        return this.name.compareTo(other);
    }

}

class ProfilesOrdenate implements Comparator<Profile> {
    @Override
    public int compare(Profile o1, Profile o2) {
        if(o1 == null)
            return -1;
        if(o2 == null)
            return 1;
        int response = o1.completeName.compareTo(o2.completeName);
        if(response != 0)
            return response;
        return Integer.compare(o1.birthyear, o2.birthyear);
    }
}

public class Subscribe {
    public static void main(String[] args) {
        System.out.println("     -------------------    ");
        System.out.println("|--- |Event Subscribers| ---|");
        System.out.println("     -------------------    ");

        ArrayList<Profile> profiles = new ArrayList<Profile>();

        profiles.add(new Profile("Nátaly", "Gomes", 2002, "student"));
        profiles.add(new Profile("Camila", "Frayna", 2003, "social communicator"));
        profiles.add(new Profile("Lucas", "Silva", 2002, "computer engineer"));
        profiles.add(new Profile("Jardeane", "Gomes", 1997, "computer engineer"));
        profiles.add(new Profile("Kendricks", "Torres", 2002, "software engineer"));
        profiles.add(new Profile("Guthyerri", "Alexandrino", 2002, "CEO of Kasparov Institute"));

        profiles.sort(new ProfilesOrdenate());

        System.out.println(profiles);

        for(Profile profile : profiles) {
            if(profile.name.equals("Nátaly")) {
                System.out.println("Info About " + profile.name);
                System.out.println(profile);
            }
        }

        
    }
}
