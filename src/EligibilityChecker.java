public class EligibilityChecker {
      // creating array and storing objects of Percentagerule,.
    private EligibilityRule[] rules;

    public EligibilityChecker() {
        rules = new EligibilityRule[] {
            new PercentageRule(),
            new BacklogRule(),
            new GraduationYearRule(),
            new SkillRule()
        };
    }
        // creating method to check candidate and job
    public boolean evaluate(Candidate candidate, Job job) {
        // creating variable for holding eligibility status
        boolean eligible = true;
        //  running a loopfrom
        for (int i = 0; i < rules.length; i++) {
            boolean passed = rules[i].check(candidate, job);

            if (passed) {
                System.out.println(rules[i].getRuleName() + " : PASS");
            } else {
                System.out.println(rules[i].getRuleName() + " : FAIL");
                eligible = false;
            }
        }

        return eligible;
    }
}