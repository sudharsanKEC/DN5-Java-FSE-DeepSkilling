import trainersMock from "./TrainersMock";
import { Link } from "react-router-dom";

function TrainersList() {
    return (
        <div>
            <h2>Trainers List</h2>
            <ul>
                {
                    trainersMock.map(trainer => (
                        <li key={trainer.trainerId}>
                            <Link to={`/trainers/${trainer.trainerId}`}>
                                {trainer.name}
                            </Link>
                        </li>
                    ))
                }
            </ul>
        </div>
    );
}

export default TrainersList;