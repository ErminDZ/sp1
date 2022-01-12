import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const Harbour = () => {
    const [harbourList, setHarbourList] = useState([]);
    useEffect(() => {
        facade.fetchData("harbour")
            .then(data => {
                setHarbourList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>List Of Owners</h2>
            <table className="table mt-4">
                <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>address</th>
                    <th>capacity</th>
                </tr>
                </thead>
                <tbody>
                {
                    harbourList.map((harbour, index) => (
                        <tr>
                            <td>{harbour.id}</td>
                            <td>{harbour.name}</td>
                            <td>{harbour.address}</td>
                            <td>{harbour.capacity}</td>

                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}



export default Harbour;