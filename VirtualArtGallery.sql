use hexadb;
CREATE TABLE Artwork (
    artworkID INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    creationDate DATE,
    medium VARCHAR(100),
    imageURL VARCHAR(255)
);

CREATE Table User (
userId int ,
userName varchar(255) ,
artworkId int
)


select * from Artwork;
select * from User;
drop table Artwork;
drop table user;