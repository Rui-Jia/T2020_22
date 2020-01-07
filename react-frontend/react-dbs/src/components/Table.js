import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import 'typeface-roboto';

const useStyles = makeStyles({
    table: {
        maxWidth: 400,
        textAlign: "justify",
        marginLeft: "110px",
    },
});

function createData(name, data) {
    return { name, data};
}

const rows = [
    createData('Account Balance (Start of Year)', 262),
    createData('Credit', 159),
    createData('Debit', 237),
    createData('Account Balance (End of Year)', 305),
];

export default function SimpleTable({ data }) {
    const classes = useStyles();

    return (
        <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>Account Expenditure</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map(row => (
                        <TableRow key={row.name}>
                            <TableCell component="th" scope="row">
                                {row.name}
                            </TableCell>
                            <TableCell>{row.data}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}