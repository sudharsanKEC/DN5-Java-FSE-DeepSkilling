import cohorts from "../data/CohortData";
import styles from "../styles/CohortDetails.module.css";

function CohortDetails() {
    return (
        <div>
            <h1>Cohorts Details</h1>
            {
                cohorts.map(cohort => (
                    <div
                        key={cohort.id}
                        className={styles.box}
                    >
                        <h3
                            style={{
                                color:
                                    cohort.currentStatus === "Ongoing"
                                        ? "green"
                                        : "blue"
                            }}
                        >
                            {cohort.name}
                        </h3>
                        <dl>
                            <dt>Started On</dt>
                            <dd>{cohort.startedOn}</dd>

                            <dt>Current Status</dt>
                            <dd>{cohort.currentStatus}</dd>

                            <dt>Coach</dt>
                            <dd>{cohort.coach}</dd>

                            <dt>Trainer</dt>
                            <dd>{cohort.trainer}</dd>
                        </dl>
                    </div>
                ))
            }
        </div>
    );
}

export default CohortDetails;