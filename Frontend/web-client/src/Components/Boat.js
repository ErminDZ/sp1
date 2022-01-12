import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const Boat = () => {
    const [boatList, setBoatList] = useState([]);
    useEffect(() => {
        facade.fetchData("boat")
            .then(data => {
                setBoatList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>List Of Owners</h2>
            <table className="table mt-4">
                <thead>
                <tr>
                    <th>boat_id</th>
                    <th>brand</th>
                    <th>make</th>
                    <th>name</th>
                    <th>image</th>
                </tr>
                </thead>
                <tbody>
                {
                    boatList.map((boat, index) => (
                        <tr>
                            <td>{boat.id}</td>
                            <td>{boat.brand}</td>
                            <td>{boat.make}</td>
                            <td>{boat.name}</td>
                            <td><img src={`/images/${boat.image}`} width="70" /></td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}



export default Boat;