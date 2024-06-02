public class Ticket implements Comparable <Ticket> {
    int Row,Seat;
    double Price;
    Person person;

    public Ticket(int row, int seat, double price, Person person) {
        this.Row = row;
        this.Seat = seat;
        this.Price = price;
        this.person = person;
    }

    void print(){
        System.out.println("Name:"+person.Name);
        System.out.println("Surname:"+person.Surname);
        System.out.println("email:"+person.Email);
        System.out.println("Row:"+Row);
        System.out.println("Seat:"+Seat);
        System.out.println("Price:"+Price+"\n");

    }

    @Override
    public int compareTo(Ticket s) {
        if(s.Price < Price){
            return 1;
        }
        else if(s.Price > Price){
            return -1;
        }
        else {
            return 0;
        }
    }
}
