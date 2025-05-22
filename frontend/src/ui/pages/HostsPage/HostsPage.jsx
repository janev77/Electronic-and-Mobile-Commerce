import React, {useState} from 'react';
import {Box, Button, CircularProgress, TextField, Typography} from "@mui/material";
import useHosts from "../../../hooks/useHosts.js";
import "./HostsPage.css";
import AddHostDialog from "../../components/hosts/AddHostDialog/AddHostDialog.jsx";
import HostsGrid from "../../components/hosts/HostsGrid/HostsGrid.jsx";

const HostsPage = () => {
    const {hosts, loading, onAdd, onEdit, onDelete} = useHosts();
    const [addHostDialogOpen, setAddHostDialogOpen] = useState(false);

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
                            All hosts ({hosts.length})
                        </Typography>
                        <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                            <Button variant="contained" color="success" onClick={() => setAddHostDialogOpen(true)}>
                                Add host
                            </Button>
                        </Box>
                        <HostsGrid hosts={hosts} onEdit={onEdit} onDelete={onDelete}/>
                    </>}
            </Box>
            <AddHostDialog
                open={addHostDialogOpen}
                onClose={() => setAddHostDialogOpen(false)}
                onAdd={onAdd}
            />
        </>
    );
};

export default HostsPage;