/**
 * AudioCollage creates a library for manipulating digital audio and uses it to
 * create an audio collage.
 * Sound is represented as an array of real numbers between -1 and +1, with
 * 44,100 samples per second.
 * The library provides functions to produce various audio effects by
 * manipulating these arrays.
 */
public class AudioCollage {
    // The functions must not mutate the argument array(s).

    /**
     * Returns a new array that rescales a[] by a multiplicative factor of alpha.
     * This increases the volume when alpha > 1 and decreases it when 0 < alpha < 1.
     *
     * @param a     the input sound array
     * @param alpha the scaling factor (must be > 0)
     * @return a new array with scaled samples
     */
    public static double[] amplify(double[] a, double alpha) {
        double[] aRescaleArr = new double[a.length];
        for (int i = 0; i < aRescaleArr.length; i++) {
            aRescaleArr[i] = a[i] * alpha;
        }
        return aRescaleArr;
    }

    /**
     * Returns a new array that is the reverse of a[].
     * This can lead to unexpected and entertaining results.
     *
     * @param a the input sound array
     * @return a new array with samples in reverse order
     */
    public static double[] reverse(double[] a) {
        double[] aReverseArr = new double[a.length];
        for (int i = 0; i < aReverseArr.length; i++) {
            aReverseArr[i] = a[a.length - 1 - i];
        }
        return aReverseArr;
    }

    /**
     * Returns a new array that is the concatenation of a[] and b[].
     * If the two sounds have m and n samples, then the resulting sound has m + n
     * samples.
     * This enables you to play two sounds sequentially.
     *
     * @param a the first sound array
     * @param b the second sound array
     * @return a new array containing both sounds in sequence
     */
    public static double[] merge(double[] a, double[] b) {
        double[] abMergeArr = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            abMergeArr[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            abMergeArr[i + a.length] = b[i];
        }
        return abMergeArr;
    }

    /**
     * Returns a new array that is the sum of a[] and b[],
     * padding the shorter arrays with trailing 0s if necessary.
     * This enables you to play two sounds simultaneously.
     *
     * @param a the first sound array
     * @param b the second sound array
     * @return a new array containing the sum of both sounds
     */
    public static double[] mix(double[] a, double[] b) {
        // Approach #1
        int greaterLength = Math.max(a.length, b.length);
        double[] abSumArr = new double[greaterLength];

        // Copy first array
        for (int i = 0; i < a.length; i++) {
            abSumArr[i] = a[i];
        }

        // Add second array
        for (int i = 0; i < b.length; i++) {
            abSumArr[i] += b[i];
        }

        // return sum of arrays
        return abSumArr;
    }

    /**
     * Returns a new array that changes the speed by the given factor.
     * If the existing sound has n samples, then the new sound has ⌊n/α⌋ samples,
     * with sample i of the new sound having the same amplitude as sample ⌊iα⌋
     * of the existing sound.
     *
     * @param a     the input sound array
     * @param alpha the speed factor (must be > 0)
     * @return a new array with modified speed
     */
    public static double[] changeSpeed(double[] a, double alpha) {
        int originalSamples = a.length;
        int updatedSamples = (int) (originalSamples / alpha);
        double[] aChangeSpeedArr = new double[updatedSamples];

        for (int i = 0; i < aChangeSpeedArr.length; i++) {
            aChangeSpeedArr[i] = a[(int) (i * alpha)];
        }

        return aChangeSpeedArr;
    }

    /**
     * Creates an audio collage and plays it on standard audio.
     * Requirements:
     * - Duration must be between 10 and 60 seconds (441,000 to 2,646,000 samples)
     * - All samples must be between -1 and +1
     * - Must use at least five different WAV files
     * - Must use all audio effects (amplify, reverse, merge, mix, change speed)
     */
    public static void main(String[] args) {
        // Read and process audio files with various effects
        // 1. Amplify Circle of Life
        // StdAudio.play(amplify(StdAudio.read("circleOfLifeLK.wav"), 2));

        // 2. Merge Wedding Speech and Dream MLK
        // StdAudio.play(merge(StdAudio.read("momWeddingSpeech.wav"),
        // StdAudio.read("dreamMLK.wav")));

        // Read input audio files
        double[] sample1 = StdAudio.read("cow.wav");
        double[] sample2 = StdAudio.read("silence.wav");
        double[] sample3 = StdAudio.read("piano.wav");
        double[] sample4 = StdAudio.read("harp.wav");
        double[] sample5 = StdAudio.read("chimes.wav");

        // Apply audio effects
        double[] edit1 = amplify(sample1, 0.5);
        double[] edit2 = reverse(sample3);
        double[] edit3 = merge(edit1, sample4);
        double[] edit4 = changeSpeed(sample5, 1.2);
        double[] edit5 = mix(edit2, edit4);
        double[] edit6 = merge(edit3, edit5);
        double[] edit7 = merge(edit6, sample2);

        // Play the final edited audio
        StdAudio.play(edit7);

        // Play each effect in sequence
        StdAudio.play(edit5);
    }
}
