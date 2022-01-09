import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const Owner = () => {
    const [ownersList, setOwnersList] = useState([]);
    useEffect(() => {
        facade.fetchData("owner")
            .then(data => {
                setOwnersList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>List Of Owners</h2>
            <table className="table mt-4">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone</th>
                </tr>
                </thead>
                <tbody>
                {
                    ownersList.map((owner, index) => (
                        <tr>
                            <td>{owner.id}</td>
                            <td>{owner.name}</td>
                            <td>{owner.address}</td>
                            <td>{owner.phone}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}



export default Owner;