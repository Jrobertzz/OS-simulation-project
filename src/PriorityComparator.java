import java.util.Comparator;

public class PriorityComparator implements Comparator<ProcessControlBlock>
{
    @Override
    public int compare(ProcessControlBlock p1, ProcessControlBlock p2)
    {
        if (p1.getPriority() < p2.getPriority())
        {
            return -1;
        }
        if (p1.getPriority() > p2.getPriority())
        {
            return 1;
        }
        return 0;
    }
}