package sg.edu.nus.iss.club;

public class Member extends Person {

    private int memberNumber;

    public Member (String surname, String firstName, String secondName,
						int memberNumber) {
        super (surname, firstName, secondName);
        this.memberNumber = memberNumber;
    }

    public int getMemberNumber () {
        return memberNumber;
    }

    public String toString () {
        return (memberNumber + " - " + super.toString ());
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memberNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		super.equals(other);
		if (memberNumber != other.memberNumber)
			return false;
		return true;
	}
    
}
