import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CarRental {
    public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {

		List<RentalTime> rentTimes = (List<RentalTime>) rentalTimes;
		Collections.sort(rentTimes);
		for (int i = 0; i <= rentalTimes.size() - 2; i++) {
			System.out.println(i);
			System.out.println(rentTimes.get(i).getEnd());
			System.out.println(rentTimes.get(i + 1).getStart());
			if (rentTimes.get(i).getEnd().compareTo(rentTimes.get(i + 1).getStart()) > 0) {
				return false;
			}
		}
		return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));

        System.out.println(CarRental.canScheduleAll(rentalTimes));
    }
}

class RentalTime implements Comparable<RentalTime> {
    private Date start, end;
    
    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
	}

	@Override
	public int compareTo(RentalTime u) {
		return start.compareTo(u.getStart());
	}
}