import "./App.css";

import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {
    const showBooks = true;
    const showBlogs = true;
    const showCourses = true;
    return (
        <div className="App">
            <h1>Blogger Application</h1>
            {
                showBooks &&
                <BookDetails />
           }
            <hr />
            {
                showBlogs
                    ? <BlogDetails />
                    : <h3>No Blogs Available</h3>
            }
            <hr />
            {
                showCourses
                    ? <CourseDetails />
                    : null
            }
        </div>
    );
}
export default App;