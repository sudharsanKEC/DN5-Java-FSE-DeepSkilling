import { useParams } from "react-router-dom";
import trainersMock from "./TrainersMock";

function TrainerDetails() {
    const { id } = useParams();
    const trainer = trainersMock.find(
        trainer => trainer.trainerId === id
    );
    if (!trainer) {
        return <h2>Trainer Not Found</h2>;
    }
    return (
        <div>
            <h2>Trainers Details</h2>
            <h3>
                {trainer.name} ({trainer.technology})
            </h3>
            <p>{trainer.email}</p>
            <p>{trainer.phone}</p>
            <ul>
                {
                    trainer.skills.map(skill => (
                        <li key={skill}>{skill}</li>
                    ))
                }
            </ul>
        </div>
    );
}
export default TrainerDetails;