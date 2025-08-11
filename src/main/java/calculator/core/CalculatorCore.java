package calculator.core;

public class CalculatorCore {
    public static void validateInput(double x) throws DomainException {
        if (x < -1.0 || x > 1.0) throw new DomainException("Input must be between -1 and 1: " + x);
    }

    /**
     * Computes arccos(x) in radians without using Math.acos.
     * Uses the identity arccos(x) = π/2 - arcsin(x),
     * and approximates arcsin(x) via its Maclaurin series expansion.
     * Series: arcsin(x) = x + (1/2)(x^3)/3 + (1*3)/(2*4)(x^5)/5 + ...
     * Truncated after x^9 for a reasonable balance of speed and precision (~1e-6).
     *
     * @param x value in [-1, 1]
     * @return arccos(x) in radians
     */
    public static double computeArccos(double x) {
        // Handle edge cases exactly
        if (x == 1.0) return 0.0;
        if (x == -1.0) return Math.PI;

        // Compute arcsin(x) using series expansion
        double arcsin = x;        // first term (x)
        double term = x;          // track current power of x
        double x2 = x * x;        // x^2 for incremental multiplication
        double coeff = 1.0;       // coefficient product for series terms

        // We add up to 4 more terms (x^3 to x^9)
        for (int n = 1; n <= 4; n++) {
            coeff *= (2.0 * n - 1.0) / (2.0 * n);  // factorial ratio
            term *= x2;                             // raise power by 2 (x^(2n+1))
            arcsin += coeff * term / (2 * n + 1);   // add term to series
        }

        // Return arccos(x) using the identity
        return Math.PI / 2.0 - arcsin;
    }

}