import React, {useState} from 'react';
import {Box, Button, CircularProgress, TextField, Typography} from "@mui/material";
import useCountries from "../../../hooks/useCountries.js";
import "./CountriesPage.css";
import AddCountryDialog from "../../components/countries/AddCountryDialog/AddCountryDialog.jsx";
import CountriesGrid from "../../components/countries/CountriesGrid/CountriesGrid.jsx";

const CountriesPage = () => {
    const {countries, loading, onAdd, onEdit, onDelete} = useCountries();
    const [addCountryDialogOpen, setAddCountryDialogOpen] = useState(false);

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
                            All countries ({countries.length})
                        </Typography>
                        <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                            <Button variant="contained" color="success" onClick={() => setAddCountryDialogOpen(true)}>
                                Add Country
                            </Button>
                        </Box>
                        <CountriesGrid countries={countries} onEdit={onEdit} onDelete={onDelete}/>
                    </>}
            </Box>
            <AddCountryDialog
                open={addCountryDialogOpen}
                onClose={() => setAddCountryDialogOpen(false)}
                onAdd={onAdd}
            />
        </>
    );
};

export default CountriesPage;