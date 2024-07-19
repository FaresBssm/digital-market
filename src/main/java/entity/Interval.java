package entity;

public class Interval {
    private Long start;
    private Long end;

    public Interval(Long start, Long end) {
        if (start > end) {
            throw new IllegalArgumentException("Start must be less than or equal to end");
        }
        this.start = start;
        this.end = end;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        if (start > this.end) {
            throw new IllegalArgumentException("Start must be less than or equal to end");
        }
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        if (end < this.start) {
            throw new IllegalArgumentException("End must be greater than or equal to start");
        }
        this.end = end;
    }

    public boolean contains(Long value) {
        return value >= start && value <= end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
