import React, {PropTypes} from 'react';
import Header from '../Header';
import 'bootstrap/dist/css/bootstrap.css';
import MoviesTable from '../MoviesTable';
import {connect} from 'react-redux';
import {addToFavourites, removeFromFavourites, changeOrder} from '../../actions/moviesActions';
import {bindActionCreators} from 'redux';

class App extends React.Component {
    render() {
        const favourites = this.props.movies.favourites.map(id => {
            return this.props.movies.all.find(movie => movie.id == id);
        });
        const nonFavourites = this.props.movies.nonFavourites.map(id => {
            return this.props.movies.all.find(movie => movie.id == id);
        }).sort((a, b) => {
            return a.title.localeCompare(b.title);
        });

        return (
            <div>
                <Header/>
                <div className="container">
                    <MoviesTable 
                        title="Favourites"
                        movies={favourites}
                        action={this.props.actions.removeFromFavourites}
                        changeOrder={this.props.actions.changeOrder}
                    />
                    <MoviesTable
                        title="All"
                        movies={nonFavourites}
                        action={this.props.actions.addToFavourites}
                    />
                </div>
            </div>
        );
    }
}

App.propTypes = {
    movies: PropTypes.shape({
        all: PropTypes.arrayOf(PropTypes.shape({
            id:PropTypes.string,
            title: PropTypes.string,
            year: PropTypes.number,
            plot: PropTypes.string
        })).isRequired,
        favourites: PropTypes.arrayOf(PropTypes.string),
        nonFavourites: PropTypes.arrayOf(PropTypes.string)
    }) 
}

function mapStateToProps(store) {
    return {movies: store.movies}
}

function mapDispatchToProps(dispatch) {
    return {actions: bindActionCreators({addToFavourites, removeFromFavourites, changeOrder}, dispatch)};
}

export default connect(mapStateToProps, mapDispatchToProps)(App);