export function addToFavourites(id) {
    return {type: 'ADD_TO_FAVOURITES', id};
}

export function removeFromFavourites(id) {
    return {type: 'REMOVE_FROM_FAVOURITES', id};
}

export function changeOrder(id, value) {
    return {type: 'CHANGE_ORDER', id, value};
}