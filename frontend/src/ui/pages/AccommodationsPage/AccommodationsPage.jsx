import React, {useState} from 'react';
import {Box, Button, CircularProgress, TextField, Typography} from "@mui/material";
import useAccommodations from "../../../hooks/useAccommodations.js";
import "./AccommodationsPage.css";
import AddAccommodationDialog from "../../components/accommodations/AddAccommodationDialog/AddAccommodationDialog.jsx";
import AccommodationsGrid from "../../components/accommodations/AccommodationsGrid/AccommodationsGrid.jsx";
import useAccommodationStats from "../../../hooks/useAccommodationStats.js";
import AccommodationsBarChart from "../../components/accommodations/AccommodationsBarChart/AccommodationsBarChart.jsx";
import ReserveAccommodationDialog
    from "../../components/accommodations/ReserveAccommodationDialog/ReserveAccommodationDialog.jsx";



const AccommodationsPage = () => {
    const {accommodations, loading, onAdd, onEdit, onDelete, onReserve} = useAccommodations();
    const [addAccommodationDialogOpen, setAddAccommodationDialogOpen] = useState(false);
    const [reserveAccommodationDialogOpen, setReserveAccommodationDialogOpen] = useState(false);
    const { stats } = useAccommodationStats();


    return (
        <>
            <Box className="products-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress/>
                    </Box>
                )}
                {!loading &&
                    <>
                        <Typography variant="h4" component="h1">
                            All accommodations ({accommodations.length})
                        </Typography>
                        <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                            <Button variant="contained" color="success" onClick={() => setAddAccommodationDialogOpen(true)}>
                                Add Accommodation
                            </Button>
                        </Box>

                        <Box sx={{display: "flex", justifyContent: "center", mb: 5}}>
                            <AccommodationsBarChart stats={stats} />
                        </Box>


                        <AccommodationsGrid accommodations={accommodations} onEdit={onEdit} onDelete={onDelete} onReserve={onReserve}/>
                    </>}
            </Box>
            <AddAccommodationDialog
                open={addAccommodationDialogOpen}
                onClose={() => setAddAccommodationDialogOpen(false)}
                onAdd={onAdd}
            />
            <ReserveAccommodationDialog
                open={reserveAccommodationDialogOpen}
                onClose={() => setReserveAccommodationDialogOpen(false)}
                onReserve={onReserve}
            />
        </>
    );
};

export default AccommodationsPage;