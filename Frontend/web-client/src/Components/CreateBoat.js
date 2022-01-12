import {useState, useEffect} from "react";
import facade from "../ApiFacade";
import {useParams} from "react-router-dom";
import {Input} from "reactstrap";

const CreateBoat = ({userName}) => {

    const [boats, setBoats] = useState([]); // add rating
    const [boat, setBoat] = useState({}); // show rating
    const [username, setUsername] = useState({}); // show username


    let {boat_id} = useParams();

    // add comment
    const addBoat = (event) => {
        event.preventDefault(); // prevent page from reloading after submitting form
        const body = {"username": userName, "boat_id": boat_id, ...boat};
        setUsername({body})
        facade.postData(body, "AddBoat").then(() => {
        })
    }

    const changeBoat = (event) => {
        event.preventDefault();
        setBoat({...boat, [event.target.id]: event.target.value});
    }
    return (


        <div className="boats">
            <form onChange={changeBoat}>
                <h5>Boat Name</h5>
                <Input name="boats" className="form-control mt-3" id="boat"  rows="3"
                          name="boat"></Input>

                <h5>Brand</h5>
                <Input name="boats" className="form-control mt-3" id="boat"  rows="3"
                       name="boat"></Input>

                <h5>Make</h5>
                <Input name="boats" className="form-control mt-3" id="boat"  rows="3"
                       name="boat"></Input>

                <button onClick={addBoat} type="submit" className="btn btn-success mt-3 float-end">Send</button>
            </form>
        </div>
    )
}
export default CreateBoat;