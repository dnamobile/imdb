package com.imdb.adapter.api;

/**
 * Available endpoints for Rapid API.
 * @author Danilo Portela
 */
public enum TitleEndpoint{

	GET_TOP_STRIPEGET("title/get-top-stripe"),
	GET_TITLE_AUTOCOMPLETE("title/auto-complete"),
	GET_POPULAR_MOVIES_BY_GENRE("title/get-popular-movies-by-genre"),
	GET_TOP_CAST("title/get-top-cast"),
	GET_OVERVIEW_DETAILS("title/get-overview-details"),
	GET_VERSIONS("title/get-versions"),
	GET_MOST_POPULAR_MOVIES("title/get-most-popular-movies"),
	GET_TAGLINES("title/get-taglines"),
	GET_PLOTS("title/get-plots"),
	GET_PARENTAL_GUIDE("title/get-parental-guide"),
	GET_COMMING_SOON_TV_SHOWS("title/get-coming-soon-tv-shows"),
	GET_TECHNICAL("title/get-technical"),
	GET_TOP_CREW("title/get-top-crew"),
	GET_RATINGS("title/get-ratings"),
	GET_METACRITIC("title/get-metacritic"),
	GET_USER_REVIEWS("title/get-user-reviews"),
	GET_DETAILS("title/get-details"),
	AUTOCOMPLETE("title/auto-complete"),
	GET_AWARDS_SUMMARY("title/get-awards-summary"),
	GET_HERO_WITH_PROMOTED_VIDEO("title/get-hero-with-promoted-video"),
	GET_COMMING_SOON_MOVIES("title/get-coming-soon-movies"),
	GET_BASE("title/get-base"),
	GET_SEASONS("title/get-seasons"),
	GET_TOP_RATED_MOVIES("title/get-top-rated-movies"),
	GET_PRODUCTION_STATUS("title/get-production-status"),
	GET_RELEASE_EXPECTATION_BUNDLE("title/get-release-expectation-bundle"),
	GET_NEWS("title/get-news"),
	GET_POPULAR_GENRES("title/list-popular-genres"),
	GET_REVIEWS("title/get-reviews"),
	GET_MOST_POPULAR_TV_SHOWS("title/get-most-popular-tv-shows"),
	GET_SYNOPSES("title/get-synopses"),
	GET_GENRES("title/get-genres"),
	GET_CHARNAME_LIST("title/get-charname-list"),
	GET_MORE_LIKE_THIS("title/get-more-like-this"),
	FIND("title/find"),
	GET_BEST_PICTURE_WINNERS("title/get-best-picture-winners"),
	GET_TOP_RATED_TV_SHOWS("title/get-top-rated-tv-shows"),
	GET_VIDEOS("title/get-videos"),
	GET_IMAGES("title/get-images"),
	GET_ALL_IMAGES("title/get-all-images"),
	GET_FILMING_LOCATIONS("title/get-filming-locations"),
	GET_META_DATA("title/get-meta-data"),
	GET_RELEASES("title/get-releases");
	
	
	/** Route for API endpoint */
	private String route;
	
	TitleEndpoint(String route){
		this.route = route;
	}
	
	public String getRoute() {
		return this.route;
	}
}