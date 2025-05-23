import React, {useState} from 'react';
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import {Box, Button, Card, CardActions, CardContent, Typography} from "@mui/material";
import EditCountryDialog from "../EditCountryDialog/EditCountryDialog.jsx";
import DeleteCountryDialog from "../DeleteCountryDialog/DeleteCountryDialog.jsx";
import {useNavigate} from "react-router";
import FlagIcon from '@mui/icons-material/Flag';

const CountryCard = ({country, onEdit, onDelete}) => {
    const navigate = useNavigate();

    const[editCountryDialogOpen, setEditCountryDialogOpen] = useState(false);
    const[deleteCountryDialogOpen, setDeleteCountryDialogOpen] = useState(false);

    return (
        <>

            <Card sx={{boxShadow: 3, borderRadius: 2}}>

                  <CardContent>

                      <Typography variant="h5">
                          <FlagIcon></FlagIcon> {country.name} </Typography>
                      <Typography variant="body1" fontWeight="bold"
                                  sx={{fontSize: "1.25rem"}}>{country.continent}</Typography>
                  </CardContent>

                <CardActions sx={{justifyContent: "space-between"}}>
                    <Box>
                        <Button
                            size="small"
                            color="info"
                            startIcon={<InfoIcon/>}
                            sx={{mr: "0.25rem"}}
                            onClick={() => navigate(`/country/${country.id}`)}
                        >
                            Info
                        </Button>
                        <Button
                            size="small"
                            color="warning"
                            startIcon={<EditIcon/>}
                            sx={{mr: "0.25rem"}}
                            onClick={() => setEditCountryDialogOpen(true)}
                        >
                            Edit
                        </Button>
                        <Button
                            size="small"
                            color="error"
                            startIcon={<DeleteIcon/>}
                            onClick={() => setDeleteCountryDialogOpen(true)}
                        >
                            Delete
                        </Button>
                    </Box>
                </CardActions>
            </Card>
            <EditCountryDialog
                open={editCountryDialogOpen}
                onClose={() => setEditCountryDialogOpen(false)}
                country={country}
                onEdit={onEdit}
            />
            <DeleteCountryDialog
                open={deleteCountryDialogOpen}
                onClose={() => setDeleteCountryDialogOpen(false)}
                country={country}
                onDelete={onDelete}
            />
        </>
    );
};

export default CountryCard;