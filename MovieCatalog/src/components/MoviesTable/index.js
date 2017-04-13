import React, {PropTypes} from 'react';
import './movies-table.css';
import {Table, Popover, OverlayTrigger} from 'react-bootstrap';
import classnames from 'classnames';

class MoviesTable extends React.Component {
    render() {
        const rows = this.props.movies.map(movie => {
            const glyphClasses = classnames('glyphicon', {
                'glyphicon-star': !!this.props.changeOrder,
                'glyphicon-star-empty': !this.props.changeOrder
            })
            const infoPopover = (
                <Popover id="plot-popover" className="plot-popover" title={`${movie.title} (${movie.year})`}>
                    <img src={movie.poster} className="poster pull-left"/>
                    <p> {`${movie.plot}`} </p>
                </Popover>
            );

            return (<tr key={movie.id}>
                    <td className="status">
                        <div className={glyphClasses} onClick={() => this.props.action(movie.id)} />
                    </td>
                    <td>
                        <OverlayTrigger trigger="click" rootClose overlay={infoPopover}>
                            <span className="movie-title"> {`${movie.title} (${movie.year})`} </span>
                        </OverlayTrigger>
                    </td>
                    { this.props.changeOrder ?
                        <td className="order">
                            <div className="glyphicon glyphicon-chevron-up" onClick={() => this.props.changeOrder(movie.id, -1)} />
                            <div className="glyphicon glyphicon-chevron-down" onClick={() => this.props.changeOrder(movie.id, 1)} />
                        </td> : null
                    }
                </tr>);
        });

        return (
            <Table responsive>
            <thead>
                <tr className="title">
                    <th colSpan={3}> {this.props.title} </th>
                </tr>
            </thead>
            <tbody>
                {rows}
            </tbody>
            </Table>
        );
    }
}

MoviesTable.propTypes = {
    title: PropTypes.string.isRequired,
    movies: PropTypes.arrayOf(PropTypes.shape({
        id: PropTypes.string,
        title: PropTypes.string,
        year: PropTypes.number,
        plot: PropTypes.string
    })).isRequired,
    changeOrder: PropTypes.func,
    action: PropTypes.func
}

export default MoviesTable;