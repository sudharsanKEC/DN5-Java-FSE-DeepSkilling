import React from "react";

function CourseDetails() {
    const courses = [
        {
            id: 1,
            course: "React",
            duration: "45 Days"
        },
        {
            id: 2,
            course: "Spring Boot",
            duration: "60 Days"
        },
        {
            id: 3,
            course: "Azure",
            duration: "30 Days"
        }
    ];
    return (
        <div>
            <h2>Course Details</h2>
            <ul>
                {
                    courses.map(course => (
                        <li key={course.id}>
                            {course.course}
                            {" - "}
                            {course.duration}
                        </li>
                    ))
                }
            </ul>
        </div>
    );
}
export default CourseDetails;