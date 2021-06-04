import java.util.Stack;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;



/**
 * left to do input for towers, source tower and destination tower
 */




public class TowerOfHanoi {

    /**
     * Represents a disk movable between towers.
     */
    public static class Disk implements Comparable<Disk> {

        /**
         * Creates a new instance of given size.
         *
         * @param size the size of the newly created disk; must be positive.
         */
        public Disk(final int size) {
            super();
            if (size <= 0) {
                throw new IllegalArgumentException("size(" + size + ") <= 0");
            }
            this.size = size;
        }

        /**
         * Returns a string representation of this disk.
         *
         * @return a string representation of this disk.
         */
        @Override
        public String toString() {
            return "disk(" + size + ")";
        }

        /**
         * Compares this disk with the specified disk for order. Returns a negative integer, zero, or a positive integer
         * as this disk's {@code size} is less than, equal to, or greater than the specified disk's {@code size}.
         *
         * @param disk the disk whose {@code size} is compared.
         * @return a negative integer, zero, or a positive integer * as this disk's {@code size} is less than, equal to,
         * or greater than the specified disk's {@code size}.
         * @see Integer#compare(int, int)
         */
        public int compareTo(final Disk disk) {
            return Integer.compare(size, disk.size);
        }

        /**
         * The size of this disk.
         */
        public final int size;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Represent a tower to (or from) which disks are moved.
     */
    public static class Tower {

        /**
         * Create a new instance of given name with specified number of disks.
         *
         * @param name  the name of newly created tower.
         * @param disks initial number of disks; {@code 0} for an empty tower.
         */
        public Tower(final String name, final int disks) {
            super();
            this.name = requireNonNull(name);
            if (disks < 0) {
                throw new IllegalArgumentException("disks(" + disks + ") < 0");
            }
            stack = new Stack<>();
            for (int size = disks; size > 0; size--) {
                stack.push(new Disk(size));
            }
        }

        /**
         * Creates a new instance with given name without disks.
         *
         * @param name the name of the newly created tower.
         */
        public Tower(final String name) {
            this(name, 0);
        }

        /**
         * Returns a string representation of this tower.
         *
         * @return a srring represetation of this tower.
         */
        @Override
        public String toString() {
            return name + stack.stream().map(d -> Integer.toString(d.size)).collect(joining(",", "(", ")"));
        }

        /**
         * Pushes a disk to this tower's disk stack.
         *
         * @param disk the to be pushed.
         * @return the pushed disk.
         * @throws IllegalArgumentException if given disk's {@code size} is equals or larger than the one of top placed
         *                                  disk of this tower.
         */
        private Disk push(final Disk disk) {
            if (!stack.isEmpty()) {
                final Disk peeked = stack.peek();
                if (peeked.compareTo(disk) <= 0) {
                    throw new IllegalArgumentException(
                            "disk.size(" + disk.size + ") is larger than the top.size(" + peeked);
                }
            }
            return stack.push(disk);
        }

        /**
         * Moves a disk from this tower to given tower.
         *
         * @param tower the tower to which a disk of this tower is moved.
         * @return the moved disk.
         */
        public Disk moveTo(final Tower tower) {
            if (stack.isEmpty()) {
                throw new IllegalStateException("no available disk to move");
            }
            return tower.push(stack.pop());
        }

        /**
         * Moves a disk from given tower to this tower.
         *
         * @param tower the tower from which a disk is move.
         * @return the moved disk.
         */
        public Disk moveFrom(final Tower tower) {
            return tower.moveTo(this);
        }

        /**
         * The name of this tower.
         */
        public final String name;

        /**
         * The stack for piled disks.
         */
        private final Stack<Disk> stack;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Moves given number of disks from a tower to another tower using an auxiliary tower.
     *
     * @param disks     the number of disks to move.
     * @param source    the tower from which disks are moved.
     * @param target    the tower to which disks are moved.
     * @param auxiliary the auxiliary tower to use.
     */
    private static void move(final int disks, final Tower source, final Tower target, final Tower auxiliary) {
        if (disks <= 0) {
            throw new IllegalArgumentException("disks(" + disks + ") <= 0");
        }
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        if (target == null) {
            throw new NullPointerException("target is null");
        }
        if (auxiliary == null) {
            throw new NullPointerException("auxiliary is null");
        }
        if (disks == 1) {
            // Move one disk from source directly to target.
            final Disk disk = source.moveTo(target);
            System.out.printf("%1$s moved from %2$s to %3$s\n", disk, source, target);
            return;
        }
        // Move disks, except the last one, from source to auxiliary.
        move(disks - 1, source, auxiliary, target);
        // Move the last disk from source to target.
        move(1, source, target, auxiliary);
        // Move all disks from auxiliary to target.
        move(disks - 1, auxiliary, target, source);
    }

    /**
     * The main method of this program.
     *
     * @param args comman line arguments whose first element is the number of disks to move.
     */
    public static void main(String[] args) {
        final int disks;
        final int t;
        final int s;
        final int d;
        try {
            disks = Integer.parseInt(args[0]);
            t = Integer.parseInt(args[1]);
            s = Integer.parseInt(args[2]);
            d = Integer.parseInt(args[3]);

        } catch (final ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Please specify the number of disks.");
            return;
        }
        if (disks <= 0) {
            System.out.println("Please specifity the positive number of disks");
            return;
        }
        final Tower source = new Tower("source", disks);
        final Tower target = new Tower("target");
        final Tower auxiliary = new Tower("auxiliary");
        move(disks, source, target, auxiliary);
    }

    /**
     * Creates a new instance.
     */
    private TowerOfHanoi() {
        super();
    }
}