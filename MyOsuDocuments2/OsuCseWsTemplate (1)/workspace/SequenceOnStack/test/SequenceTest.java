import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     * constructor test.
     */

    @Test
    public final void sequenceOnStackConstructorTest() {
        Sequence<String> seq = this.constructorTest();
        Sequence<String> seqExpected = this.constructorRef();

        assertEquals(seqExpected, seq);
    }

    /**
     * add method test.
     *
     */

    @Test
    public final void sequenceOnStackAddTest() {
        Sequence<String> seq = this.createFromArgsTest("blue", "red");
        Sequence<String> seqExpected = this.createFromArgsRef("blue", "red", "green");

        seq.add(seq.length(), "green");

        assertEquals(seqExpected, seq);

    }

    /**
     * The remove method test.
     */

    @Test
    public final void sequenceOnStackRemoveTest() {

        Sequence<String> seq = this.createFromArgsTest("blue", "red");
        Sequence<String> seqExpected = this.createFromArgsRef("blue");

        seq.remove(1);

        assertEquals(seqExpected, seq);

    }

    /**
     * The length method Test.
     */

    @Test
    public final void sequenceOnStackLengthTest() {

        Sequence<String> seq = this.createFromArgsTest("blue", "red");
        Sequence<String> seqExpected = this.createFromArgsRef("blue", "red");

        int count = seq.length();
        int countExpected = seqExpected.length();

        assertEquals(countExpected, count);

    }

}
