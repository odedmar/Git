import org.joda.time.DateTime;


public class HostingCount {
	DateTime reservationDate;
	String hosting;
	
	public final DateTime getReservationDate() {
		return reservationDate;
	}
	public final void setReservationDate(DateTime reservationDate) {
		this.reservationDate = reservationDate;
	}
	public final String getHosting() {
		return hosting;
	}
	public final void setHosting(String hosting) {
		this.hosting = hosting;
	}
	@Override
	public String toString() {
		return "HostingCount [reservationDate=" + reservationDate
				+ ", hosting=" + hosting + "]";
	}
	
	

}
