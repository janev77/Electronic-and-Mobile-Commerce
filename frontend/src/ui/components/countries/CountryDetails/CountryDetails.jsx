import React from 'react';
import {useNavigate, useParams} from "react-router";
import useCountryDetails from "../../../../hooks/useCountryDetails.js";
import {
    Box,
    Button,
    Chip,
    CircularProgress,
    Grid,
    Typography,
    Paper,
    Avatar,
    Stack,
    Rating,
    Breadcrumbs,
    Link
} from "@mui/material";
import {
    ArrowBack,
    Category,
    Factory,
    Star,
    ShoppingCart,
    FavoriteBorder,
    Share
} from "@mui/icons-material";
import useHostCounts from "../../../../hooks/useHostCounts.js";

const HostDetails = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const {country} = useCountryDetails(id);
    const hostCounts = useHostCounts();

    const hostCount = hostCounts.find(entry => entry.countryId === Number(id))?.numHosts ?? 0;

    if (!country) {
        return (
            <Box sx={{display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '60vh'}}>
                <CircularProgress/>
            </Box>
        );
    }

    return (
        <Box>
            <Breadcrumbs aria-label="breadcrumb" sx={{mb: 3}}>
                <Link
                    underline="hover"
                    color="inherit"
                    href="#"
                    onClick={(e) => {
                        e.preventDefault();
                        navigate("/countries");
                    }}
                >
                    Countries
                </Link>
                <Typography color="text.primary">{country.name}</Typography>
            </Breadcrumbs>

            <Paper elevation={2} sx={{p: 4, borderRadius: 4}}>
                <Grid container spacing={1}>
                    <Grid size={{xs: 12, md: 9}}>
                        <Box sx={{mb: 3}}>
                            <Typography variant="h3" gutterBottom sx={{fontWeight: 600}}>
                                {country.name}
                            </Typography>
                        </Box>
                    </Grid>
                    <Grid size={{xs: 12, md: 9}}>
                        <Box sx={{mb: 3}}>
                            <Typography variant="h5" gutterBottom sx={{fontWeight: 600}}>
                                {country.continent}
                            </Typography>
                        </Box>
                    </Grid>
                    <Grid size={{xs: 12, md: 9}}>
                        <Box sx={{mb: 3}}>
                            <Typography variant="body1" gutterBottom sx={{fontWeight: 600}}>
                                Number of hosts: {hostCount}
                            </Typography>
                        </Box>
                    </Grid>
                    <Button
                        variant="outlined"
                        color="success"
                        startIcon={<ArrowBack/>}
                        onClick={() => navigate("/countries")}
                    >
                        Back to Countries
                    </Button>
                </Grid>
            </Paper>
        </Box>
    );
};

export default HostDetails;