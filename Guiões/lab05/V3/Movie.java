import java.time.Year;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person>cast;
    private final List<Place>locations;
    private final List<String>languages;
    private final List<String>genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder{
        private final String title;
        private final int year = Year.now().getValue();
        private final Person director = null;
        private final Person writer = null;
        private final String series = null;
        private final List<Person>cast = null;
        private final List<Place>locations = null;
        private final List<String>languages = null;
        private final List<String>genres = null;
        private final boolean isTelevision = false;
        private final boolean isNetflix = false;
        private final boolean isIndependent = false;

        public Builder(String title) {
            this.title = title;
        }

        public Builder year(int year){
            this.year = year;
            return this;
        }

        public Builder director(Person director){
            this.director = director;
            return this;
        }

        public Builder writer(Person writer){
            this.writer = writer;
            return this;
        }

        public Builder series(String series){
            this.series = series;
            return this;
        }

        public Builder cast(List<Person>cast){
            this.cast = cast;
            return this;
        }

        public Builder locations(List<Place>locations){
            this.locations = locations;
            return this;
        }

        public Builder languages(List<String>languages){
            this.languages = languages;
            return this;
        }

        public Builder genres(List<String>genres){
            this.genres = genres;
            return this;
        }

        public Builder isTelevision(boolean isTelevision){
            this.isTelevision = isTelevision;
            return this;
        }

        public Builder isNetflix(boolean isNetflix){
            this.isNetflix = isNetflix;
            return this;
        }

        public Builder isIndependent(boolean isIndependent){
            this.isIndependent = isIndependent;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    } // end of Builder class

    private Movie(Builder builder){
        this.title = builder.title;
        this.year = builder.year;
        this.director = builder.director;
        this.writer = builder.writer;
        this.series = builder.series;
        this.cast = builder.cast;
        this.locations = builder.locations;
        this.languages = builder.languages;
        this.genres = builder.genres;
        this.isTelevision = builder.isTelevision;
        this.isNetflix = builder.isNetflix;
        this.isIndependent = builder.isIndependent;
    }

} 
